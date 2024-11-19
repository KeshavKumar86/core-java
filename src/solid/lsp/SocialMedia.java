package solid.lsp;

public abstract class SocialMedia {
    //support whatsapp, facebook, instagram
    public abstract void chatWithFriend();
    //support facebook and instagram
    public abstract  void publishPost(Object post);
    //support whatsapp,facebook,instagram
    public abstract  void sendPhotosAndVideos();
    //support whatsapp,facebook
    public abstract void groupVideoCall(String ... users);

}
