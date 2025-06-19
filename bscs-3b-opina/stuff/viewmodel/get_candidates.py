from stuff.model.candidates import candidates

manager = candidates()
all_candidates = manager.get_all()
president_list = manager.get_by_position("President")

for candidate in president:
    print(candidate["name"])
    
manager = candidates()
all_candidates = manager.get_all()
vice_president_list = manager.get_by_position("Vice President")

for candidate in vice_president:
    print(candidate["name"])
    
manager = candidates()
all_candidates = manager.get_all()
senator_list = manager.get_by_position("Senator")

for candidate in senator:
    print(candidate["name"])
    
manager = candidates()
all_candidates = manager.get_all()
representative = manager.get_by_position("Representative")

for candidate in representative:
    print(candidate["name"])