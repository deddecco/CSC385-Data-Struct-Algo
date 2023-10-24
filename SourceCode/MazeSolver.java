package SourceCode;

import java.util.Stack;

/**
 * Notes:
 * <p>
 * The start and end position are contained within the maze object. Use the
 * getStart() and getEnd() methods.
 *
 * @author Brian Rogers
 */
public class MazeSolver {
     /*
      * @param maze: The maze to be solved.
      * @return An array of Position which stores a solution to the maze. If a
      * solution is not found a null value should be returned.
      */
     public static Position[] solve(Maze maze) {
          //initialize a Stack of Positions called positionStack with the start Position
          // mark start visited
          // initialize current position to start
          Stack<Position> positionStack = new Stack<>();
          positionStack.push(maze.getStart());
          maze.setAt(maze.getStart(), 'V');
          Position currentPosition = maze.getStart();


          //while(stack is not empty and current position is not yet end):
          //	pickDirection(maze)
          //	if direction is null
          //		pop
          //		if stack has any elements
          //			current position = top of stack
          //	else
          //		mark square arrived at by moving in chosen direction as visited
          //		mark square arrived at by moving in chosen direction as current position
          //		push current position
          //end while
          while (!positionStack.isEmpty() && !currentPosition.equals(maze.getEnd())) {
               String directionToMove = pickDirection(maze, currentPosition);

               // directionToMove will be null iff backtracking is required
               if (directionToMove == null) {
                    // backtrack
                    positionStack.pop();
                    if (!positionStack.isEmpty()) {
                         // get the value, but don't remove it from the stack,
                         // only if there is a value to be gotten from the stack
                         currentPosition = positionStack.peek();
                    }
               } else {
                    Position newPosition = getNewPosition(directionToMove, currentPosition);
                    // set that position visited
                    maze.setAt(newPosition, 'V');
                    // go there
                    currentPosition = newPosition;
                    // push it onto the stack
                    positionStack.push(currentPosition);
               }
          }

          // if outside the while loop the position stack has any positions, then those positions form a path
          if (!positionStack.isEmpty()) {
               return generatePositionArray(positionStack);
          }
          else {
               // if outside the while loop the position stack is empty, then there is no solution
               return new Position[0];
          }
     }

     // given the current position and the direction to move,
     // determine where you will be after moving from your current position in that direction
     private static Position getNewPosition(String directionToMove, Position currentPosition) {
          int rowOffset = 0;
          int colOffset = 0;

          // if directionToMove isn't null, then it's either north, south, east, or west
          // for each of those, one of the following: the rowOffset or the colOffset is +1 or -1
          // and the other component of the movement is 0
          if (directionToMove.equalsIgnoreCase("North")) {
               rowOffset = 1;
          }
          if (directionToMove.equalsIgnoreCase("South")) {
               rowOffset = -1;
          }
          if (directionToMove.equalsIgnoreCase("East")) {
               colOffset = 1;
          }
          if (directionToMove.equalsIgnoreCase("West")) {
               colOffset = -1;
          }

          // create amd return a new position from the given offsets
          return new Position(currentPosition.getRow() + rowOffset,
                  currentPosition.getColumn() + colOffset);
     }
     private static Position[] generatePositionArray(Stack<Position> positionStack) {
          Position[] positions = new Position[positionStack.size()];

          int arraySize = positionStack.size() - 1;
          for (int i = arraySize; i >= 0; i--) {
               positions[i] = positionStack.pop();
          }

          return positions;
     }
     // a move is helpful iff it is valid and the space to which a move is being made is clear
     public static boolean moveIsHelpful(Maze maze, Position position, int moveRowOffset, int moveColOffset) {
          boolean valid = maze.validPosition(position.getRow() + moveRowOffset, position.getColumn() + moveColOffset);

          if (!valid) {
               return false;
          }

          return maze.getAt(position.getRow() + moveRowOffset, position.getColumn() + moveColOffset) == ' ';
     }
     // either returns a direction in which movement is helpful,
     // or returns null if no such direction exists from the current position and backtracking is required
     public static String pickDirection(Maze maze, Position position) {
          if (moveIsHelpful(maze, position, 1, 0)) {
               return "North";
          } else if (moveIsHelpful(maze, position, -1, 0)) {
               return "South";
          } else if (moveIsHelpful(maze, position, 0, 1)) {
               return "East";
          } else if (moveIsHelpful(maze, position, 0, -1)) {
               return "West";
          } else {
               return null;
          }
     }
}