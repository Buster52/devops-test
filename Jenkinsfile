pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    environment {
        repo = "${env.repo}"
        commit_message = "${env.commit_message}"
        author = "${env.author}"
		pr=""
    }
    stages {
        stage('Sonar scan') {
            steps {
                echo 'Scan code with sonar'
				echo 'Value of pr ${pr}'
				  script{
					  def funciones = load 'funciones.groovy'
					  funciones.mavenScan()
					  pr="hola"
				  }
            }
        }
		stage('Check Sonar results'){
		  steps{
			script{
			  echo 'Check analysis status'
			  echo 'Value of pr ${pr}'
			  def analysisStatus = sh(returnStatus: true, script: 'curl -s -u squ_fdff963a578f81664d7afd1e7c37651791ec111b: "http://192.168.0.3:9000/api/qualitygates/project_status?projectKey=mapstruct" | jq -r ".projectStatus.status"')
				if(analysisStatus == 'OK'){
				  echo 'Quality gate success'
				}else{
				  currentBuild.result = 'FAILURE'
                  error('Pipeline aborted due to quality gate failure.')
				}
			}
		  }
		}
		stage('Build app'){
			steps{
				echo 'Building application'
				sh 'mvn -B -ntp clean package'
			}
		}
    }
	post{
	  success{
			script{
				def funciones = load 'funciones.groovy'
				funciones.sendEmail(repo, commit_message, author)
			}
	  }
	}
}
