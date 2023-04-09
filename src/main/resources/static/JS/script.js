function matchPassword()
{
    if(document.getElementById('rpassword').value!=document.getElementById('password').value)
    {
	  alert("Confirm password does not match with password")
	  return false;
    }
    return true;
}
function checkNo()
{
	if(document.getElementById('pn').value>document.getElementById('tp').value){
		alert("Page number should not be greater than total pages")
		return false;
	}
	return true;	
}
