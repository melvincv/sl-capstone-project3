// Declarative pipeline, with scripted pipeline inside a script {} block.
pipeline {
    // Use any agent: shell, docker, etc.
    agent any
    // Parameters are used for user input at build time, with a set default value.
    parameters {
        // String parameter
        string(name: 'IMAGE_TAG', defaultValue: 'latest', description: 'Enter a tag for the Docker Image')
        // Boolean param evaluates to true or false
        booleanParam(name: 'DOCKER_BUILD', defaultValue: false, description: 'Build and Push to Docker Hub?')
    }
    stages {
        // Build stage, with Maven
        stage('build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        // Test stage that calls a script test-db.sh.
        // This starts a MySQL container for the Maven test that follows
        // Refer to the script at the repo root for more.
        stage('test') {
            steps {
                sh 'bash ./test-db.sh'
            }
        }
        // Using Jenkins credentials, build and push to Docker Hub.
        // This used scripted pipeline syntax in script {}
        stage('Docker Build and Push') {
            when { expression { return params.DOCKER_BUILD } }
            steps {
                script {
                    docker.withRegistry('', 'docker_hub_login') {
                        def app=docker.build("melvincv/springbootcrudapp")
                        app.push("${params.IMAGE_TAG}")
                    }
                }
            }
        }
    }
    // End of stages block
    // What to do after running the stages, according to the pipeline result? 
    post {
        unstable {
            echo 'Pipeline is unstable...'
        }
        success {
            echo 'Pipeline Succeeded! Archiving artifacts...'
            // Artifacts will be made available in Jenkins Pipeline Status page.
            archiveArtifacts artifacts: '**/target/*.jar', followSymlinks: false
        }
        failure {
            echo 'Pipeline failed...'
        }
    }
}