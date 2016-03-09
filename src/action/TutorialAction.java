package action;

import service.TutorialFinderService;

public class TutorialAction 
{
	private String bestTutorialSite;
	private String language = "";
	
	public String getTutorialMethod()
	{
		TutorialFinderService obj = new TutorialFinderService();
		setBestTutorialSite ( obj.findTutorial(getLanguage()) );
		System.out.println("getTutorialMethod executed");
		return "success";
	}
	
	public String addTutorialMethod()
	{
		TutorialFinderService obj = new TutorialFinderService();
		setBestTutorialSite ( obj.findTutorial(getLanguage()) );
		System.out.println("addTutorialMethod executed");
		return "success";
	}
	
	public String execute()
	{
		TutorialFinderService obj = new TutorialFinderService();
		setBestTutorialSite ( obj.findTutorial(getLanguage()) );
		System.out.println("hi");
		return "success";
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBestTutorialSite() {
		return bestTutorialSite;
	}

	public void setBestTutorialSite(String bestTutorialSite) {
		this.bestTutorialSite = bestTutorialSite;
	}

	
}
