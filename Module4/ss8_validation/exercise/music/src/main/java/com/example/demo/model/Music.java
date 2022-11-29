package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Tên bài hát không được rỗng")
    @Size(max = 800, message = "Tên bài hát không được quá 800 ký tự")
    @Pattern(regexp = "^([A-Z]*[0-9a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[ ])*([A-Z]*[0-9a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$", message = "Tên bài hát không được chứa ký tự đặc biệt")
    private String name;
    @NotEmpty(message = "Tên nghệ sĩ không được rỗng")
    @Size(max = 300, message = "Tên nghệ sĩ không được quá 300 ký tự")
    @Pattern(regexp = "^([A-Z]*[a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[ ])*([A-Z]*[a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$", message = "Tên nghệ sĩ không được chứa số hoặc ký tự đặc biệt")
    private String artistName;
    @NotEmpty(message = "Thể loại không được rỗng")
    @Size(max = 1000, message = "Thể loại không được quá 800 ký tự")
    @Pattern(regexp = "^([A-Z]*[0-9a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ,]*[ ])*([A-Z]*[0-9a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ,]*)$", message = "Tên bài hát không được chứa ký tự đặc biệt ngoại trừ dấu phẩy")
    private String category;


    public Music() {
    }

    public Music(Long id, @NotEmpty(message = "Tên bài hát không được rỗng") @Size(max = 800, message = "Tên bài hát không được quá 800 ký tự") @Pattern(regexp = "^([A-Z]*[0-9a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[ ])*([A-Z]*[0-9a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$", message = "Tên bài hát không được chứa ký tự đặc biệt") String name, @NotEmpty(message = "Tên nghệ sĩ không được rỗng") @Size(max = 300, message = "Tên nghệ sĩ không được quá 300 ký tự") @Pattern(regexp = "^([A-Z]*[a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[ ])*([A-Z]*[a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$", message = "Tên nghệ sĩ không được chứa số hoặc ký tự đặc biệt") String artistName, @NotEmpty(message = "Thể loại không được rỗng") @Size(max = 1000, message = "Thể loại không được quá 800 ký tự") @Pattern(regexp = "^([A-Z]*[0-9a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ,]*[ ])*([A-Z]*[0-9a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ,]*)$", message = "Tên bài hát không được chứa ký tự đặc biệt ngoại trừ dấu phẩy") String category) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
