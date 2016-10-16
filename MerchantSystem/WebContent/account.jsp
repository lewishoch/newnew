<style>
#account_control {
	float: right;
    margin-right: 15%;
    margin-top: 15px;
    width: 80%;
}
</style>
<div id="account_control">
	<form action="logout" method="post" class="form-group">
		<label>Welcome, ${merchantAccount.uname}!</label><span>      </span>
		<input type="submit" value="Logout" class="btn btn-warning"/>
	</form>
</div>
</br>