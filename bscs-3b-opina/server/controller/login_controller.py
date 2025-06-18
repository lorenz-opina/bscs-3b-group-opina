from flask import request, render_template
from extensions import db
from server.model.users_db import User
from werkzeug.security import check_password_hash

def hello():
    username = request.form.get("username")
    password = request.form.get("password")

    user = User.query.filter_by(username=username).first()

    if user and check_password_hash(user.password, password):
        return f"Welcome, {user.username}!"
    else:
        return render_template("dashboard.html")