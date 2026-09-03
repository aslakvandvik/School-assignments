# Source: Grokking Algorithms by Aditya Y. Bhargava

def find_states(states_needed, stations):
    # This function implements a greedy algorithm to find the minimum number of stations that cover all the states needed.
    # Parameters:
    # states_needed (set): A set of states that need coverage.
    # stations (dict): A dictionary where keys are station names and values are sets of states covered by the station.
    # Returns:
    # final_stations (set): A set of station names that covers all the states needed with the minimum number of stations.
    
    final_stations = set()
    
    while states_needed:
        best_station = None
        states_covered = set()
        for station, states in stations.items():
            covered = states_needed & states
            if len(covered) > len(states_covered):
                best_station = station
                states_covered = covered

        states_needed -= states_covered
        final_stations.add(best_station)

    return final_stations

states_needed = {'mt', 'wa', 'or', 'id', 'nv', 'ut', 'ca', 'az'}
stations = dict()
stations['k1'] = {'id', 'nv', 'ut'}
stations['k2'] = {'wa', 'id', 'mt'}
stations['k3'] = {'or', 'nv', 'ca'}
stations['k4'] = {'nv', 'ut'}
stations['k5'] = {'ca', 'az'}

find_states(states_needed, stations)
