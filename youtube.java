import java.util.*;

interface WithoutBadWordsAble {
    public boolean moderate(Video video);
}

interface RightInformationAble {
    public boolean rightInformation(Video video);
}

class Video {
    private String title;
    private String description;
    private int likes;
    private int dislikes;
    private String[] comments;
    private int commentsCount;
    private int timing;
    private String textVersion;
    private boolean desinformation;

    public int getTiming() { return timing; }

    public String getTextVersion() { return textVersion; }

    public boolean getDesinformation() { return this.desinformation; }

    public Video(String title, int timing, String description, String textVersion, boolean desinformation) {
        this.title = title;
        this.description = description;
        this.likes = 0;
        this.dislikes = 0;
        this.commentsCount = 0;
        this.comments = new String[100];
        this.timing = timing;
        this.textVersion = textVersion;
        this.desinformation = desinformation;
    }

    public Video(String title, int timing) {
        this(title, timing, "", "", false);
    }

    public void like() { likes += 1; }
    public void dislike() { dislikes += 1; }

    public void leaveComment(String text) {
        comments[commentsCount] = text;
        commentsCount += 1;
    }

}

abstract class Channel {
    private String name;
    protected String description;
    protected int videosCount;
    protected Video[] videos;
    protected int subscribersCount;
    protected Channel[] subscribers;

    protected Channel(String name, String description) {
        this.name = name;
        this.description = description;
        subscribersCount = 0;
        subscribers = new Channel[100];
        videosCount = 0;
        videos = new Video[100];
    }

    public Channel(String name) {
        this(name, "");
    }

    public String getName() { return this.name; }

    public void subscribe(Channel channel) {
        subscribers[subscribersCount] = channel;
        subscribersCount += 1;
    }

    public abstract void deployVideo(Video video);
}


class EntertaimentChannel extends Channel {
    private String badCompanies[];
    private int badCompaniesCount;
    private final int badCompanyCapacity = 100;

    public EntertaimentChannel(String name, String description) {
        super(name, description);
        badCompanies = new String[badCompanyCapacity];
        badCompaniesCount = 0;
        initializeBadCompanies();
    }

    private void initializeBadCompanies() {
        String companies[] = new String[] { "1xBet", "Казино Вулкан"};
        for (String c : companies) {
            badCompanies[badCompaniesCount] = c;
            badCompaniesCount += 1;
        }
    }

    public EntertaimentChannel(String name) {
        this(name, "");
    }

    public void adverb(Channel channel) {
        boolean flag = false;
        for (String c : badCompanies) {
            if (channel.getName() == c) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Мы не можем рекламировать зашквар");
        } else {
            System.out.println("Рекомендуем " + channel.getName());
        }
    }


    public void deployVideo(Video video) {
        if (video.getTiming() > 15) {
            System.out.println("Ваше видео слишком длинное, никто не будет столько времени тратить на развлечение");
        } else {
            videos[videosCount] = video;
            videosCount += 1;
        }
    }
}

class ScienceChannel extends Channel implements WithoutBadWordsAble, RightInformationAble {
    private String[] scienceThemes;
    private int scienceThemesCount;
    private final int scienceThemesCapacity = 10;

    public ScienceChannel(String name, String description) {
        super(name, description);
        scienceThemes = new String[scienceThemesCapacity];
        scienceThemesCount = 0;
    }

    public ScienceChannel(String name) {
        this(name, "");
    }

    public void addScienceTheme(String scienceTheme) {
        scienceThemes[scienceThemesCount] = scienceTheme;
        scienceThemesCount += 1;
    }

    public boolean moderate(Video video) {
        if (video.getTextVersion() == "дебил" || video.getTextVersion() == "дурак") {
            return false;
        } else {
            return true;
        }
    }

    public void deployVideo(Video video) {
        if (moderate(video) && rightInformation(video)) {
            videos[videosCount] = video;
            videosCount += 1;
        }
    }

    public boolean rightInformation(Video video) {
        if (!video.getDesinformation()) {
            return true;
        }
        return true;
    }
}

class ChildChannel extends EntertaimentChannel implements WithoutBadWordsAble {

    public ChildChannel(String name, String description) {
        super(name, description);
    }

    public ChildChannel(String name) {
        this(name, "");
    }

    public void adverb(Channel channel) {
        if (channel instanceof WithoutBadWordsAble) {
            System.out.println("Мы не можем рекламить каналы, использующие ненормативную лексику");
        } else {
            super.adverb(channel);
        }
    }

    public void deployVideo(Video video) {
        if (moderate(video)) {
            super.deployVideo(video);
        } else {
            System.out.println("В видео ненормативная лексика");
        }
    }

    public boolean moderate(Video video) {
        if (video.getTextVersion() != "дурак" || video.getTextVersion() != "дебил") {
            return true;
        } else {
            return false;
        }
    }
}












