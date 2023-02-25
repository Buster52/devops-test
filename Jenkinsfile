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
                def funciones = load 'funciones.groovy'
                echo 'build stage'
                funciones.mavenScan()
            }
        }
    }
}
