#!/usr/bin/env python3
# Python 3.6

# Import the Halite SDK, which will let you interact with the game.
import hlt

# This library contains constant values.
from hlt import constants

# This library contains direction metadata to better interface with the game.
from hlt.positionals import Direction

# This library allows you to generate random numbers.
import random

# Logging allows you to save messages for yourself. This is required because the regular STDOUT
#   (print statements) are reserved for the engine-bot communication.
import logging

""" <<<Game Begin>>> """

# This game object contains the initial game state.
game = hlt.Game()
# At this point "game" variable is populated with initial map data.
# This is a good place to do computationally expensive start-up pre-processing.
# As soon as you call "ready" function below, the 2 second per turn timer will start.
game.ready("ASBot")

ship_status = {}

# Now that your bot is initialized, save a message to yourself in the log file with some important information.
#   Here, you log here your id, which you can always fetch from the game object by using my_id.
logging.info("Successfully created bot! My Player ID is {}.".format(game.my_id))

""" <<<Game Loop>>> """

while True:
    # This loop handles each turn of the game. The game object changes every turn, and you refresh that state by
    #   running update_frame().
    game.update_frame()
    # You extract player metadata and the updated map metadata here for convenience.
    me = game.me
    game_map = game.game_map

    # A command queue holds all the commands you will run this turn. You build this list up and submit it at the
    #   end of the turn.
    command_queue = []

    direction_order = [Direction.North, Direction.South, Direction.East, Direction.West, Direction.Still]

    positionChoices = []

    shipStates = {}
    
    for ship in me.get_ships():

        if ship.id not in shipStates:
            shipStates[ship.id] = "collecting"

        #Logging information
        logging.info("Ship {} has {} halite.".format(ship.id, ship.halite_amount))

        #Gives information about Halite in surrounding areas
        choices = ship.position.get_surrounding_cardinals() + [ship.position]

        posDict = {}
        hltDict = {}

        for n, direction in enumerate(direction_order):
            posDict[direction] = position_options[n]

        for direction in posDict:
            position = posDict[direction]
            haliteAmount = game_map[position].halite_amount
            if posDict[direction] not in position_choices:
                if direction == Direction.Still
                    hltDict[direction] = haliteAmount * 3
                else:
                    hltDict[direction] = haliteAmount
            else:
                logging.info("Attempting to move to same spot\n")

        if game.turn_number == 10:
            logging.info(choices)
        
        #Gives certian status to ship and determines moves
        if ship.id not in ship_status:
            ship_status[ship.id] = "exploring"

        if ship_status[ship.id] == "returning":
            if ship.position == me.shipyard.position:
                ship_status[ship.id] = "exploring"
            else:
                move = game_map.naive_navigate(ship, me.shipyard.position)
                command_queue.append(ship.move(move))
                continue
        elif ship.halite_amount >= constants.MAX_HALITE / 4:
            ship_status[ship.id] = "returning"

        # For each of your ships, move randomly if the ship is on a low halite location or the ship is full.
        # Else, collect halite.
        if shipStates[ship.id] == "depositing":
            move = game_map.naive_navigate(ship, me.shipyard.position)
            positionChoices.append(posDict[move])
            command_queue.append(ship.move(move))
            if move = Direction.Still:
                shipStates[ship.id] = "collecting"
        
        elif shipStates[ship.id] == "collecting":
            directional_choice = max(hltDict, key=hltDict.get)
            positionChoices.append(posDict[directional_choice])
            command_queue.append(ship.move(game_map.naive_navigate(ship, posDict[directional_choice])))

            if ship.halite_amount > contstants.MAX_HALITE * .95:
                shipStates[ship.id] = "depositing"

    # If the game is in the first 200 turns and you have enough halite, spawn a ship.
    # Don't spawn a ship if you currently have a ship at port, though - the ships will collide.
    if game.turn_number <= 200 and me.halite_amount >= constants.SHIP_COST and not game_map[me.shipyard].is_occupied:
        command_queue.append(me.shipyard.spawn())

    # Send your moves back to the game environment, ending this turn.
    game.end_turn(command_queue)

