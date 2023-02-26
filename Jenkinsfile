pipeline {
    agent any
	  node{
			def funciones = load 'funciones.groovy'
	  }
    triggers {
        pollSCM '* * * * *'
    }
    environment {
        repo = "${env.repo}"
        commit_message = "${env.commit_message}"
        author = "${env.author}"
    }
    stages {
        stage('Sonar scan') {
            steps {
                echo 'Scan code with sonar'
				funciones.mavenScan()
            }
        }
		stage('Check Sonar results'){
		  steps{
			script{
			  echo 'Check analysis status'
			  def analysisStatus = sh(returnStatus: true, script: 'curl -s -u squ_fdff963a578f81664d7afd1e7c37651791ec111b: "http://192.168.0.3:9000/api/qualitygates/project_status?projectKey=mapstruct" | jq -r ".projectStatus.status"')
				if(analysisStatus != 'OK'){
				  currentBuild.result = 'FAILURE'
                  error('Pipeline aborted due to quality gate failure.')
				}
			}
		  }
		}
		stage('Build app'){
			steps{
				echo 'Building application'
				sh 'mvn clean package'
			}
		}
    }
	post{
	  success{
		  funciones.sendEmail(repo, commit_message, author)
	  }
	}
}
