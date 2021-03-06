<html>
   <head>
      <meta name="layout" content="main"/>
      <r:require modules="bootstrap, prettify"/>
  </head>
<body>

 <h1>Random RSA Keys</h1>

  <div class="alert alert-success">
    <button class="close" data-dismiss="alert">×</button>
    <h4 class="alert-heading">Congratulations!</h4>
    Ask a friend to send you an encoded message using your public keys!
  </div>

  <div class="row-fluid">
    <div class="span4">
      <div class="alert alert-info">
        <h4 class="alert-heading">Public Key <decodr:rsaKey key="${randomRsa.publicKey}" format="copy" bgcolor="#d9edf7" /></h4>
        <decodr:rsaKey key="${randomRsa.publicKey}" />
      </div>
    </div>
    <div class="span4">
    &nbsp;
    </div>
    <div class="span4">
      <div class="alert alert-error">
        <h4 class="alert-heading">Private Key <decodr:rsaKey key="${randomRsa.privateKey}" format="copy" bgcolor="#f2dede" /></h4> 
        <decodr:rsaKey key="${randomRsa.privateKey}" />
      </div>
    </div>
  </div>

  <div class="row-fluid">
    <div class="span4">
        <g:link class="btn btn-primary btn-large"
            controller="encoder" action="index"
            params="${publicKeyMap}">
            Encode Message &raquo;</g:link></p>
    </div>
    <div class="span4">
        &nbsp;
    </div>
    <div class="span4">
        <g:link class="btn btn-primary btn-large"
            controller="decoder" action="index" 
            params="${privateKeyMap}">
            Decode Message &raquo;</g:link></p>
    </div>
  </div>

  <div class="row-fluid">
    <div class="span6">
      <h2>Public Key Generation</h2>

        <pre class="prettyprint linenums prettyprinted">
<ol class="linenums"><g:each var="logEntry" status="index" in="${randomRsa.publicKey.logEntries}"><li class="L${index}"><span class="${logEntry.contains("->") ? 'kwd' : 'pln'}">${logEntry.replace("FI", "ϕ(N)")}</span></li></g:each></ol>
        </pre>

    </div><!--/span-->
    <div class="span6">
      <h2>Private Key Generation</h2>

        <pre class="prettyprint linenums">
<ol class="linenums"><g:each var="logEntry" status="index" in="${randomRsa.privateKey.logEntries}"><li class="L${index}"><span class="${["->", "While", "then","D ="].any{logEntry.contains(it)} ? 'kwd' : 'pln'}">${logEntry.replace("FI(n)", "ϕ(N)")}</span></li></g:each></ol>
        </pre>

    </div><!--/span-->
  </div><!--/row-->
</body>
</html>
