from flask import Flask, jsonify, render_template
from server.controller.login_controller import hello
from server.controller.register_controller import register_new
from extensions import db, jwt

from flask_jwt_extended import JWTManager, get_jwt, get_jwt_identity, jwt_required

def create_app():
    app = Flask(__name__)
    app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///site.db"
    app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False
    
    app.config["JWT_TOKEN_LOCATION"] = ["cookies"]
    app.config["JWT_COOKIE_SECURE"] = False  # Set to True in production with HTTPS   
    app.config["JWT_SECRET_KEY"] = "super-secret-key"


    jwt.init_app(app)
    db.init_app(app)
    

    with app.app_context():
        db.create_all()

    @app.route("/")
    def home():
        return render_template("login.html")

    @app.route("/login", methods=["POST"])
    def auth():
        return hello()
    
    @app.route("/register")
    def register_user():
        return render_template("register.html")
    
    @app.route("/register_new", methods=["POST"])
    def submit_new():
        return register_new()
    
    @app.route("/vote")
    def voter():
        return render_template("voter.html")
    
    @app.route("/dashboard")
    @jwt_required()
    def mein_got():
        claims = get_jwt()
        if claims.get("user_type") != "admin":
            return jsonify(msg="Access denied"), 403
        return render_template("dashboard.html")
    
    @app.route("/done", methods=["POST", "GET"])
    def voter_done():
        return render_template("voter_done.html")
    
    return app

app = create_app()

if __name__ == "__main__":
    app.run(debug=True)



