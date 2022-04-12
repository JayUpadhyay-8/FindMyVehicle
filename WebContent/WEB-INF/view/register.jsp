<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="a" uri="http://java.sun.com/jstl/core_rt" %>
  <%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
         <link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath()%>/assets/images/logo-light-icon.png">
        <title>FindMyVehicle</title>
             <%--  <script src="<%=request.getContextPath()%>/adminResources/js/html5shiv.js"></script> --%>
        <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />
       <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
        <script>
        	function test()
        	{
        		var x=document.getElementById("inputPassword").value;
        		var y=document.getElementById("inputConfirmPassword").value;
        		
        		if(x==y)
        			{
	        			 var button = document.querySelector('button');
	        			 button.disabled=false;
	        		}
        		else
        			{
	        			alert("Password and ConfirmPassword must be same");
	        			var button = document.querySelector('button');
	       			 	button.disabled=true;
	       				setTimeout(function(){	 button.disabled=false;}, 3000); 	
	       				
        			}
        		
        	}
        </script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
 
 				                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                                    <div class="card-body">
                                        <f:form action="registerins.html" modelAttribute="RegisterVO" method="post">
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group"><label class="small mb-1" for="inputFirstName">First Name</label><span class="req">*</span><f:input path="firstName" type="text" class="form-control py-4" required="required" id="inputFirstName"  placeholder="Enter first name" /></div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group"><label class="small mb-1" for="inputLastName">Last Name</label><span class="req">*</span><f:input path="lastName" class="form-control py-4" id="inputLastName" required="required" type="text" placeholder="Enter last name" /></div>
                                                </div>
                                            </div>
                                             <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group"><label class="small mb-1" for="inputFirstName">DOB</label><span class="req">*</span><f:input path="dateOfBirth" class="form-control py-4" id="inputFirstName" type="date" required="required" placeholder="Enter DOB" /></div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group"><label class="small mb-1" for="inputLastName">RTO_ID</label><span class="req">*</span><f:input path="rto_id" required="required" class="form-control py-4" id="inputLastName" type="number" placeholder="Enter rto_ID" /> </div>
                                                </div>
                                            </div>
                                            <div class="form-group"><label class="small mb-1" for="inputEmailAddress">Email</label><span class="req">*</span><f:input path="loginVO.username" class="form-control py-4" id="inputEmailAddress" type="email" required="required" aria-describedby="emailHelp" placeholder="Enter email address" /></div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group"><label class="small mb-1" for="inputPassword">Password</label><span class="req">*</span><f:input path="loginVO.password" class="form-control py-4" id="inputPassword" type="password" required="required" placeholder="Enter password" /></div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group"><label class="small mb-1" for="inputConfirmPassword">Confirm Password</label><span class="req">*</span><input class="form-control py-4" id="inputConfirmPassword" type="password" required="required" placeholder="Confirm password" /></div>
                                                </div>
                                            </div>
                                            <f:hidden path="loginVO.enabled" value="1"/>
									<f:hidden path="loginVO.role" value="ROLE_USER"/>
                                            <div class="form-group mt-4 mb-0"><button type="submit" onclick="javascript:return test()" class="btn btn-primary btn-block" >Create Account</button></div>
                                        </f:form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="login.html">Have an account? Go to login</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
 				
 
 
 
                    </div>
                </main>
            </div>
            <!-- <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; FindMyVehicle 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div> -->
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/js/scripts.js"></script>
    </body>
</html>
