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
				echo "build stage"
            }
        }
    }
}

def mavenScan(){
  withSonarQubeEnv('SonarServ'){
	sh "mvn clean compile"
	  sh """
		mvn sonar:sonar \
		-Dsonar.sources=src/main \
		-Dsonar.sourceEncoding=UTF-8
	  """
  }
}
