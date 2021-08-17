job('ejemplo-job-dsl') {
  description('job dsl de ejemplo para curso')
  scm {
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') {
    node -> 
      node / gitConfigName('danie')
      node / gitConfigEmail('daniel@gmail.com')
    }
  }
  parameters {
  	stringParam('nombre',  defaultValue = 'Daniel', description = 'Parametro de string para el job')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Pluton'])
    booleanParam('agente', false)
    
  }
  triggers {
  	cron('H/1 * * * *')  
  }
  steps {
  	shell("bash jobscript.sh")
  }
  publishers {
   mailer('danielbascunand@gmail.com', true, true ) 
  }
}
