
<!DOCTYPE html>
<html>

<head>
    <title>From</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="javascript/script.js"></script>
    
</head>

<body>
  
    <h1 class="text-white text-center font-weight-bold col-lg-6 m-auto bg-success style=" font-size: 55px;"> Registraton From</h1>

    <div class="container">
    
    <br>
        <div class="col-lg-6 m-auto d-block">
            <form class="bg-light">
                <div class="form-group">
                    <label for="name" class="font-weight-bold"> Name: </label>
                    <input type="text" name="name_input" class="form-control" id="name_input" required="required" onfocusout = "funName()" autocomplete="off">
                    <span id="name_span" class="text-danger font-weight-bold"> </span>

                </div>
                <div class="form-group">
                    <label class="font-weight-bold"> Email: </label>
                    <input type="email" name="email_input" class="form-control" id="email_input" required="required" autocomplete="off" onfocusout = "funEmail()">
                    <span id="email_span" class="text-danger font-weight-bold"> </span>
                </div>
                <div class="form-group">
                    <label class="font-weight-bold"> Mobile: </label>
                    <input type="text" name="mobile_input" class="form-control" size ="10" maxlength="10" id="mobile_input" required="required" autocomplete="off" onfocusout = "funMobile()">
                    <span id="mobile_span" class="text-danger font-weight-bold"> </span>
                </div>
                
                 <div class="form-group">
                    <label class="font-weight-bold"> PinCode: </label>
                    <input type="text" name="pincode_input" maxlength="6" class="form-control" id="pincode_input" onkeyup="myfunction(this.value)" required="required"  autocomplete="off">
                    <span id="pincode_span" class="text-danger font-weight-bold"> </span>
                </div>
                
                <div class="form-group">
                    <label class="font-weight-bold" id ="area_label" name = "area_label"> Area: </label>
                    <select id="select_tag_area" name = "select_tag_area">    
                         
                    </select>
                </div>  
                
                
                <div class="form-group">
                    <label class="font-weight-bold" id ="state_label" name = "state_label"> State: </label>
                    <select id="select_tag_state" name="select_tag_state">    
                         
                    </select>
                </div> 
                
               <input type="button" name="submit" value="submit" onclick="validation()" class="btn btn-success" >
                
            </form>
        </div>
        
    </div>

</body>

</html>