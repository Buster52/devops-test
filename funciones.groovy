def mavenScan(){
  withSonarQubeEnv('SonarServ'){
	sh "mvn clean compile"
	  sh """
		mvn sonar:sonar \
        -Dsonar.projectKey=mapstruct \
		-Dsonar.sources=src/main \
		-Dsonar.sourceEncoding=UTF-8 \
	  """
  }
}
return this