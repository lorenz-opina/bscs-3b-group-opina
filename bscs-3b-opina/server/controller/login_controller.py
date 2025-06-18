from flask import request, render_template, jsonify
from extensions import db, jwt
from server.model.users_db import User
from werkzeug.security import check_password_hash

from flask_jwt_extended import create_access_token

def hello():
    username = request.form.get("username")
    password = request.form.get("password")

    user = User.query.filter_by(username=username).first()

    if user and check_password_hash(user.password, password):
        access_token = create_access_token(identity={"username": user.username, "user_type": user.user_type})

        if user.user_type == "admin":
            return render_template("dashboard.html")
        else:
            return render_template("voter.html")
    else:
        return jsonify(message="Incorrect username or password"), 401