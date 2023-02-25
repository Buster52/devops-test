funciones = load 'funciones.groovy'
pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    environment {
        repo = "${env.repo}"
        commit_message = "${env.commit_message}"
        author = "${env.author}"
    }
    stages {
        stage('Build') {
            steps {
                echo 'build stage'
                funciones.mavenScan()
            }
        }
    }
}
