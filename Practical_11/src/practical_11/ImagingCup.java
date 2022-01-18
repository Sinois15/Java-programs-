package practical_11;
 

/**
 *
 * @author User
 */
public class ImagingCup {
    private String groupName;
    private String projectTitle;
    private int noOfMembers;
    private double feePerMember=20.00;
    
    public ImagingCup(){
        this.groupName="";
        this.projectTitle="";
        this.noOfMembers=0;
    }
    public void setGroupName(String groupName){
        this.groupName=groupName;
    }
    public void setProjectTitle(String projectTitle){
        this.projectTitle=projectTitle;
    }
    public void setNoOfMembers(int noOfMembers){
        this.noOfMembers=noOfMembers;
    }
    public void setFeePerMemnber(double feePerMember){
        this.feePerMember=feePerMember;
    }
    public String getGroupName(){
        return groupName;
    }
    public String getProjectTitle(){
        return projectTitle;
    }
    public int getNoOfMembers(){
        return noOfMembers;
    }
    public double getFeePerMember(){
        return feePerMember;
    }
    public double calcCollectionPerGroup(){
        double amountCollected;
        amountCollected=noOfMembers*feePerMember;
        return amountCollected;
    }
    @Override
    public String toString(){
        return "Group Name: "+groupName+"\nProject Title: "+projectTitle+"\nNumber of Members: "+noOfMembers;
    }
}

