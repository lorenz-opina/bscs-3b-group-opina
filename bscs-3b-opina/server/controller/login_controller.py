from flask import request, render_template, jsonify
from extensions import db, jwt
from server.model.users_db import User
from werkzeug.security import check_password_hash
from flask import make_response, redirect, url_for
from flask_jwt_extended import set_access_cookies
from flask_jwt_extended import create_access_token

def hello():
    username = request.form.get("username")
    password = request.form.get("password")

    user = User.query.filter_by(username=username).first()

    if user and check_password_hash(user.password, password):
        access_token = create_access_token(
            identity=user.username,
            additional_claims={"user_type": user.user_type}
        )

        if user.user_type == "admin":
            response = make_response(redirect(url_for("mein_got")))
        else:
            response = make_response(redirect(url_for("voter")))

        set_access_cookies(response, access_token)
        return response

    else:
        return render_template("login.html", message="Incorrect username or password")