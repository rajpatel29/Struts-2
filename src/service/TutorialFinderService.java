package service;

public class TutorialFinderService 
{
	public String findTutorial(String language)
	{
		
		if(language.equals( "english" ) )
		{
			return "barclays premier league";
		}
		else
		{
			return "I dont kno man :(";
		}
	}
}
