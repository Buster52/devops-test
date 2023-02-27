pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    environment {
        repo = "${env.repo}"
        commit_message = "${env.commit_message}"
        author = "${env.author}"
		buildNumber = "${BUILD_NUMBER}"
		buildURL = "${BUILD_URL}"
    }
    stages {
        stage('Sonar scan') {
            steps {
                echo 'Scan code with sonar'
                script {
                    def funciones = load 'funciones.groovy'
                    funciones.mavenScan()
                }
            }
        }
		stage('Wait for SonarQube Analysis') {
			steps {
				script {
					sleep time: 1, unit: 'MINUTES'
				}
			}
		}
        stage('Check Sonar results') {
            steps {
                script {
                    echo 'Check sonar analysis status'
                    def analysisStatus = sh(returnStdout: true, script: 'curl -s -u squ_fdff963a578f81664d7afd1e7c37651791ec111b: "http://192.168.0.3:9000/api/qualitygates/project_status?projectKey=mapstruct" | jq -r ".projectStatus.status"')
                    if (analysisStatus.trim() == 'OK') {
                        echo 'Quality gate success'
                    } else {
                        currentBuild.result = 'FAILURE'
                        error('Pipeline aborted due to quality gate failure.')
                    }
                }
            }
        }
        stage('Build app') {
            steps {
                echo 'Building application'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Testing'){
            steps{
                echo 'Testing application'
                sh 'mvn clean test'
            }
        }
    }
    post {
        always{
            junit 'target/surefire-reports/*.xml'
        }
        success {
            script {
                def funciones = load 'funciones.groovy'
                funciones.sendEmail(repo, commit_message, author, buildNumber, buildURL)
            }
        }
    }
}