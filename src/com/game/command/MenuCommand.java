package com.game.command;

public enum MenuCommand {

	modeSelectionSinglePlayer("P_1", 1),
	modeSelectionMultiPlayer("P_2", 2),
	
	difficultySelectionEasy("D_1", 1),
	difficultySelectionNormal("D_2", 2),
	difficultySelectionHard("D_3", 3);

    private String _description;
    private int _value;
    MenuCommand(String description, int value) {
        this._description = description;
        this._value = value;
    }

    public String getDescription() {
        return _description;
    }
    
    public int getValue() {
        return _value;
    }
    
	/** Retorna um Comand de Menu a partir de uma string */
	public static MenuCommand fromString(String description) throws IllegalArgumentException {
		for (MenuCommand item : MenuCommand.values()) {
			if (item._description.equalsIgnoreCase(description)) {
				return item;
	        }
        }
        throw new IllegalArgumentException("Não foi possível encontrar o valor "+description+" em "+MenuCommand.class.getClass().getName());
	}
   
}