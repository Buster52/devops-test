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
                body: """
<style type="text/css">
.tg  {border-collapse:collapse;border-color:#ccc;border-spacing:0;}
.tg td{background-color:#fff;border-color:#ccc;border-style:solid;border-width:1px;color:#333;
  font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;word-break:normal;}
.tg th{background-color:#f0f0f0;border-color:#ccc;border-style:solid;border-width:1px;color:#333;
  font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
.tg .tg-ly6r{border-color:#efefef;text-align:center;vertical-align:top}
</style>
<table class="tg">
<thead>
  <tr>
    <th class="tg-ly6r">Product</th>
    <th class="tg-ly6r">Commit message</th>
    <th class="tg-ly6r">Author</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td class="tg-ly6r">${repo}</td>
    <td class="tg-ly6r">${commit_message}</td>
    <td class="tg-ly6r">${author}</td>
  </tr>
</tbody>
</table>""",
            subject: '[Jenkins] Job Execution',
            to: 'gonzalezf.e@outlook.com'
            }
        }
    }
}
