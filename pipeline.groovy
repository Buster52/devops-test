def call(){
  pipeline{
	options{
	  timestamps ()
	}
	stages{
	  stage('Stage 1'){
		echo "first stage"
	  }
	}
  }
}
