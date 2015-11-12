<!doctype HTML>
<html>
    <head>
        <link rel="stylesheet" href="css/style.css"/>
        <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
        <script src="scripts/functions.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                     
                    <a class="navbar-brand" href="#page-top">
                        <img src="images/oracle-logo.png" alt="" width="70%"/></a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hidden">
                            <a href="#page-top"></a>
                        </li>
                        <li class="page-scroll">
                            <a href="#portfolio">Oracle Cloud Management Portal</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
        <div class="container">
            <div class="content">
                <div id='content' class='row-fluid'>
                    <div class='col-md-2 sidebar'>
                        <h3>JCS APIs</h3>
                        <ul class="nav nav-tabs nav-stacked">
                            <li>
                                <a onclick="javascript:link1()">View All Instances</a>
                            </li>
                            <li>
                                <a onclick="javascript:link2()">View Single Instance</a>
                            </li>
                            <li>
                                <a onclick="javascript:link3()">Delete an Instance</a>
                            </li>
                            <li>
                                <a onclick="javascript:link6()">View Response Status</a>
                            </li>
                        </ul>
                        <h3>Coherence APIs</h3>
                        <ul class="nav nav-tabs nav-stacked">
                            <li>
                                <a onclick="javascript:link4()">Delete Coherence Tier</a>
                            </li>
                            <li>
                                <a onclick="javascript:link5()">Add Coherence Tier</a>
                            </li>
                        </ul>
                    </div>
                    <div class='col-md-10 main' id='frmContent'></div>
                    frmContent1
                    <hr/>
                    <div class='col-md-10 main' id='frmContent'>
                        <hr/>
                        frmContent
                        <div id="response">Click on left links</div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>