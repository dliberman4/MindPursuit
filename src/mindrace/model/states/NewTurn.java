package mindrace.model.states;

import mindrace.model.states.State;

/**
 * 
 * @author francisco
 *
 */
public class NewTurn extends State{
	public void initialize(){
		this.getSituation().nextTurn();
	}
	
	public State terminate(){
		return new ThrowingDice();
	}

	/* (non-Javadoc)
	 * @see mindrace.model.states.State#isModifier()
	 */
	@Override
	public boolean isModifier() {
		return true;
	}

}
