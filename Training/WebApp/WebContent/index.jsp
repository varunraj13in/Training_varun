<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="index.css" />
<script type="text/javascript" src="index.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<title>Store</title>
</head>

<body>
	<p id="welcome">Welcome to My Store</p>
	<p id="creation">User creation:</p>

	<form action="MyServlet" method="post" onsubmit="return checkPass()">
		<table align="center" cellpadding="5">
			<div id="hiddenError" class="hiddenError">
				<tr>
					<td><label id="mandatory" class="asterisk-b">All
							fields are Mandatory</label><br /></td>
				</tr>
				<tr>
					<td><label id="missing">The following field/s are
							missing </label></td>
				</tr>
				<tr>
					<td><label id="errors"></label></td>
				</tr>
			</div>

			<tr>
				<td><label class="asterisk" for="username">User Name</label></td>
				<td><input type="text" id="username" name="username"
					placeholder="Please enter username" maxlength="6" /><br /></td>
			</tr>
			<tr>
				<td><label class="asterisk" for="password">Password</label></td>
				<td><input type="password" id="password" name="password"
					placeholder="Please enter password" maxlength="6" /><br /></td>
			</tr>
			<tr>
				<td><label class="asterisk" for="card">Card type</label></td>
				<div class="form-radio">
					<td><input type="radio" name="card" id="credit"
						onClick="updateName()" value="Credit" /> <label for="credit">Credit</label>
						<input type="radio" name="card" id="debit" onClick="updateName()"
						value="Debit" checked /> <label for="debit">Debit</label></td>
				</div>
			</tr>
			<tr>
				<td><label class="asterisk" id="bal" for="val">Balance</label>
				</td>
				<td><input type="text" id="val" name="val"
					placeholder="Balance"
					oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');" /><br />
				</td>
			</tr>
		</table>
			<button class="form-submit" id="add" type="submit">Add</button>
	</form>
		<button class="form-submit" id="reset" onclick="reset()" type="submit">Reset</button>


	<table align="center" cellpadding="5" class="data">
		<tr>
			<th>Name</th>
			<th>Account Type</th>
			<th>Balance/Limit</th>
		</tr>
		<tr>
			<td>Ajay</td>
			<td>Credit</td>
			<td>1000</td>
		</tr>
		<tr>
			<td>Bijay</td>
			<td>Debit</td>
			<td>200</td>
		</tr>
		<tr>
			<td>Govind</td>
			<td>Debit</td>
			<td>345</td>
		</tr>
		<tr>
			<td>Hari</td>
			<td>Credit</td>
			<td>1000</td>
		</tr>
	</table>

</body>

</html>