from flask import Flask, render_template
from server.controller.login_controller import hello
from extensions import db

def create_app():
    app = Flask(__name__)
    app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///site.db"
    app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False

    db.init_app(app)

    with app.app_context():
        db.create_all()

    @app.route("/")
    def home():
        return render_template("login.html")

    @app.route("/auth", methods=["POST"])
    def auth():
        return hello()

    return app

app = create_app()

if __name__ == "__main__":
    app.run(debug=True)



