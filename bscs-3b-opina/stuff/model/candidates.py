from extensions import db 

class Candidate(db.Model):
    __tablename__ = 'users'
    
    id = db.Column(db.Integer, primary_key=True)
    first_name = db.Column(db.String(80), unique=True, nullable=False)
    last_name = db.Column(db.String(120), nullable=False)
    position = db.Column(db.String(50), nullable=False)

    def __repr__(self):
        return f"<User {self.first_name}>"