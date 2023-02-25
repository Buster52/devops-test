pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    environment {
        repo = "${env.repo}"
        commit_message = "${env.commit_message}"
        author = "${env.author}"
        funciones = load 'funciones.groovy'
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
