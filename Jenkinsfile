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
                sh 'mvn clean install'
            }
        }
        stage('Email') {
            steps {
                emailext mimeType: 'text/html',
                body: """Commit:  <table>
<thead>
  <tr>
    <th>Product</th>
    <th>Commit message</th>
    <th>Author</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>${repo}</td>
    <td>${commit_message}</td>
    <td>${author}</td>
  </tr>
</tbody>
</table>""",
            subject: '[Jenkins] Job Execution',
            to: 'gonzalezf.e@outlook.com'
            }
        }
    }
}
