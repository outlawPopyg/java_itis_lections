interface INet {
    void getMonetization();
}

interface ITV {
    void getBackgroundPeople();
}

class PoliticalProgram implements ITV {

    private String name;
    private int number;
    private String day;
    private int viewers;
    private boolean isLive;
    private int regularViewers;

    public PoliticalProgram(String name, int number, String day) {
        this.name = name;
        this.number = number;
        this.day = day;
        this.isLive = false;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void startLive() {
        this.isLive = true;
        if (this.day != "6" || this.day != "7") {
            this.viewers = 3000;
        } else {
            this.viewers = 500;
        }
    }

    public void endLive() {
        this.isLive = false;
        this.regularViewers = this.viewers / 1000;
        this.viewers = 0;
    }

    public void adverbPause() {
        if (this.isLive) {
            System.out.println("Adverb pause");
            this.viewers -= 100;
        } else {
            System.out.println("Boss, we aren't start program");
        }
    }

    public void getBackgroundPeople() {
        if (!this.isLive) {
            System.out.println("Удалось собрать массовку в размере" + this.regularViewers / 100 + " человек");
        }
    }
}

abstract class Blogger implements INet {
    protected int startCapital;
    protected int subscribers;
    protected int averageViews;
    protected int adverbPrice;
    protected String name;

    public int getSubscribers() {
        return subscribers;
    }

    Blogger(String name, int startCapital) {
        this.name = name;
        this.startCapital = startCapital;
        this.adverbPrice = 0;
    }

    Blogger(String name) {
        this(name, 0);
    }

    public abstract void buyAdverb(Blogger blogger);
    public abstract void doContent();
}

class InstagramBlogger extends Blogger {
    private int storiesCheckers;

    public InstagramBlogger(String name, int startCapital) {
        super("https://instagram.com/" + name, startCapital);
        this.subscribers = 0;
        this.storiesCheckers = 0;
    }

    public void buyAdverb(Blogger blogger) {
        this.startCapital -= blogger.adverbPrice;
        this.storiesCheckers += blogger.subscribers / 2;
    }

    public void doContent() {
        this.subscribers += this.storiesCheckers;
        this.adverbPrice += this.subscribers;
    }

    public void getMonetization() {
        if (this.averageViews > 1000) {
            this.startCapital += this.averageViews / 10;
        } else {
            System.out.println("You can't monetize it");
        }
    }
}

class YoutubeBlogger extends Blogger {

    public YoutubeBlogger(String name, int startCapital) {
        super("https://youtube.com/" + name, startCapital);
        this.subscribers = 0;
        this.averageViews = 0;
    }

    public void buyAdverb(Blogger blogger) {
        this.startCapital -= blogger.adverbPrice;
        this.averageViews += blogger.subscribers / 2;
    }

    public void doContent() {
        this.subscribers += this.averageViews * 2;
        this.adverbPrice += this.averageViews;
    }

    public void getMonetization() {
        if (this.averageViews > 1000000) {
            this.startCapital += this.averageViews / 100;
        } else {
            System.out.println("You can't monetize it");
        }
    }
}

class StandUp implements INet, ITV {
    private int viewers;
    private YoutubeBlogger youtubeAccount;
    private InstagramBlogger instagramAccount;
    private int startCapital;
    private int studioPlaces = 120;
    private int ticketPrice;

    public StandUp(String name, int startCapital, int ticketPrice) {
        this.viewers = 0;
        this.ticketPrice = ticketPrice;
        this.youtubeAccount = new YoutubeBlogger(name, startCapital / 2);
        this.instagramAccount = new InstagramBlogger(name, startCapital / 2);
    }

    public void performInStudio() {
        this.viewers += this.studioPlaces;
    }

    public void performRemotely() {
        this.instagramAccount.doContent();
        this.youtubeAccount.doContent();
        this.viewers += instagramAccount.subscribers + youtubeAccount.subscribers;
    }

    public void getMonetization() {
        this.youtubeAccount.getMonetization();
        this.instagramAccount.getMonetization();
        this.startCapital += this.instagramAccount.startCapital + this.youtubeAccount.startCapital;
    }

    public void getBackgroundPeople() {
        System.out.println("Удалось пригласить " + this.studioPlaces + " человек");
        this.startCapital += this.studioPlaces * this.ticketPrice;
    }

}








