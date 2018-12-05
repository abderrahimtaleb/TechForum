package com.big.data.Service;

import com.big.data.Entity.Post;
import com.big.data.Entity.User;
import com.big.data.HbaseConfig.HbaseConnect;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.hadoop.hbase.util.Bytes.toBytes;

@Service
public class PostService {

    private Connection connection = HbaseConnect.getInstance();
    private Table postTable;

    public Table getTable() {
        try {
            postTable = connection.getTable(TableName.valueOf("post"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postTable;
    }

    public  byte[] serialize(User obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    public  User deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return (User)is.readObject();
    }
    public List<Post> findAll()
    {
        Scan scan = new Scan();
        // Getting the scan result
        ResultScanner scanner;
        List<Post> posts = new ArrayList<>();
        try {
            scanner = getTable().getScanner(scan);

            // Reading values from scan result
            for (Result result = scanner.next(); result != null; result = scanner.next()) {

                if(result.getRow() == null)
                    return null;

                Post post = new Post();
                post.setId(Bytes.toString(result.getRow()));

                post.setTitre(Bytes.toString(result.getValue(Bytes.toBytes("meta data"), Bytes.toBytes("titre"))));
                post.setDatePublication(Bytes.toString(result.getValue(Bytes.toBytes("meta data"), Bytes.toBytes("datePublication"))));

                if(result.getValue(Bytes.toBytes("meta data"), Bytes.toBytes("auteur")) != null)
                post.setAuteur(deserialize(result.getValue(Bytes.toBytes("meta data"), Bytes.toBytes("auteur"))));

                post.setText(Bytes.toString(result.getValue(Bytes.toBytes("body data"), Bytes.toBytes("text"))));
                post.setImage(Bytes.toString(result.getValue(Bytes.toBytes("body data"), Bytes.toBytes("image"))));
                post.setVideo(Bytes.toString(result.getValue(Bytes.toBytes("body data"), Bytes.toBytes("video"))));


                posts.add(post);
            }

            //closing the scanner
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return posts;

    }

    public Post save(Post post) {
        long id = findAll().size() + 1;
        post.setId(String.valueOf(id));
        Put newPost = new Put(Bytes.toBytes(post.getId()));

        if (post.getTitre() != null)
            newPost.addColumn(Bytes.toBytes("meta data"), Bytes.toBytes("titre"), Bytes.toBytes(post.getTitre()));

        if (post.getDatePublication() != null)
            newPost.addColumn(Bytes.toBytes("meta data"), Bytes.toBytes("datePublication"), Bytes.toBytes(post.getDatePublication()));

        if (post.getAuteur() != null) {
            try {
                newPost.addColumn(Bytes.toBytes("meta data"), Bytes.toBytes("auteur"), serialize(post.getAuteur()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (post.getText() != null)
            newPost.addColumn(Bytes.toBytes("body data"), Bytes.toBytes("text"), Bytes.toBytes(post.getText()));

        if (post.getImage() != null)
            newPost.addColumn(Bytes.toBytes("body data"), Bytes.toBytes("image"), Bytes.toBytes(post.getImage()));

        if (post.getVideo() != null)
            newPost.addColumn(Bytes.toBytes("body data"), Bytes.toBytes("video"), Bytes.toBytes(post.getVideo()));


        try {
            getTable().put(newPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Inserted !");

        return post;
    }

    public void delete(String rowId) {
        Delete del = new Delete(toBytes(rowId));
        try {
            getTable().delete(del);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Deleted !");
    }





    /*
    @Autowired
    PostRepository postRepository;

    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }

    public Post findByTitre(String titre) {
        return postRepository.findByTitre(titre);
    }

    public Post findByAuteur(User auteur) {
        return postRepository.findByAuteur(auteur);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    //test
    public void savePost() {
        postRepository.savePost();
    }

    public Post update(Long id, Post post) {
        post.setId(id);
        return postRepository.save(post);
    }

    public void delete(Long post) {
        postRepository.deleteById(post);
    }

    public Set<User> like(Long id, User liker) {
        Post post = postRepository.findById(id).get();
        post.likedBy(liker);
        return postRepository.save(post).getUsersLiked();
    }

    public Set<Commentaire> comment(Long id, Commentaire commentaire) {
        Post post = postRepository.findById(id).get();
        commentaire.setPost(post);
        post.commentedBy(commentaire);
        return postRepository.save(post).getCommentaires();
    }

    public Set<Commentaire> getComments(Long id) {
        Post post = postRepository.findById(id).get();
        return post.getCommentaires();
    }

    */
}
