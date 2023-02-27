def mavenScan() {
    withSonarQubeEnv('SonarServ') {
        sh "mvn clean compile"
        sh """
		mvn sonar:sonar \
        -Dsonar.projectKey=mapstruct \
		-Dsonar.sources=src/main \
		-Dsonar.sourceEncoding=UTF-8 \
	  """
    }
}

def sendEmail(repo, commit_message, author, buildNumber, buildURL) {
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
                    </table>
                    <p>Log de build: ${buildURL}console</a>
                """,
            subject: "[Jenkins] Job Execution ${buildNumber}",
            to: 'gonzalezf.e@outlook.com'
}

return this
