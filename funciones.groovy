def mavenScan(){
  withSonarQubeEnv('SonarServ'){
	sh "mvn clean compile"
	  sh """
		mvn sonar:sonar \
		-Dsonar.sources=src/main \
		-Dsonar.sourceEncoding=UTF-8 \
	  """
  }
}