package DynamicPrograming;

/*
The Two Rules to Memorize
The Winning Rule: A state is a WIN if there is at least one move that forces the next player into a LOSS.
The Losing Rule: A state is a LOSS if every possible move hands the next player a WIN.
*/
class game {
    
    // We use the Boolean Object (capital B) instead of primitive boolean.
    // This allows the array to hold 'null' for states we haven't calculated yet,
    // 'true' for Winning states, and 'false' for Losing states.
    Boolean[] memo;

    public boolean canAliceWin(int startState) {
        // Initialize the memoization array. 
        // Size is startState + 1 to accommodate 0-indexing.
        memo = new Boolean[startState + 1];
        
        // Alice takes the first turn, so we ask: 
        // "Is the starting state a Winning state for the person taking a turn?"
        return canWin(startState);
    }

    private boolean canWin(int currentState) {
        // ---------------------------------------------------------
        // THEORY STEP 1: Has this state been solved before?
        // ---------------------------------------------------------
        // This prevents O(2^N) time complexity by instantly returning 
        // answers we already figured out in previous recursive branches.
        if (memo[currentState] != null) {
            return memo[currentState];
        }

        // ---------------------------------------------------------
        // THEORY STEP 2: The Terminal State (Base Case)
        // ---------------------------------------------------------
        // This is the absolute end of the game. 
        // In most games, if it is your turn and there is nothing left 
        // to take (0), you lose. Therefore, 0 is an L-state (false).
        if (currentState == 0) {
            return false; 
        }

        // ---------------------------------------------------------
        // THEORY STEP 3: Explore all valid moves
        // ---------------------------------------------------------
        // (Example: The rules say you can take 1, 2, or 3 stones)
        int[] possibleMoves = {1, 2, 3}; 
        
        for (int move : possibleMoves) {
            
            // Only try the move if it is legally allowed
            if (currentState - move >= 0) { 
                
                int nextState = currentState - move;

                // ---------------------------------------------------------
                // THEORY STEP 4: The Golden Rule (The "if NOT" statement)
                // ---------------------------------------------------------
                // We recursively call canWin() for the NEXT state.
                // Remember: The next state belongs to the OPPONENT.
                // If canWin(nextState) returns FALSE, it means the opponent loses.
                // If the opponent loses, WE WIN! So we return TRUE.
                if (!canWin(nextState)) {
                    memo[currentState] = true;
                    return true;
                }
            }
        }

        // ---------------------------------------------------------
        // THEORY STEP 5: The Doom Scenario
        // ---------------------------------------------------------
        // If the code makes it down here, it means the loop finished trying
        // every single possible move, and NONE of them returned false for the opponent.
        // This means every move we can make hands the opponent a W-state.
        // Therefore, our current state is an L-state.
        memo[currentState] = false;
        return false;
    }
}