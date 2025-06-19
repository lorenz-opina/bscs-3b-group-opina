from flask import request, render_template
from extensions import db
from server.model.users_db import User
from werkzeug.security import check_password_hash, generate_password_hash
 
def register_new():
    new_username = request.form.get("username")
    new_password = request.form.get("password")

    existing_user = User.query.filter_by(username=new_username).first()
    if existing_user:
        return "Username already taken. Please choose another."

    # Hash the password before storing it
    hashed_password = generate_password_hash(new_password)

    # Create and save the user
    new_user = User(username=new_username, password=hashed_password, user_type="voter")
    db.session.add(new_user)
    db.session.commit()

    return render_template("login.html", message="Registered Successfully.")
