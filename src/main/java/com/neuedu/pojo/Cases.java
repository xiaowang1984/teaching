package com.neuedu.pojo;

public class Cases extends Page{
    private Integer id;

    private String name;

    private Integer level;

    private String extend;

    private Integer type;

    private Integer count;

    private Integer language;

    private String point;

    private String pointNames;

    private String url;

    private Integer provider;

    private Integer isDel;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getProvider() {
        return provider;
    }

    public void setProvider(Integer provider) {
        this.provider = provider;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPointNames() {
        return pointNames;
    }

    public void setPointNames(String pointNames) {
        this.pointNames = pointNames;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", extend='" + extend + '\'' +
                ", type=" + type +
                ", count=" + count +
                ", language=" + language +
                ", point='" + point + '\'' +
                ", url='" + url + '\'' +
                ", provider=" + provider +
                ", isDel=" + isDel +
                ", description='" + description + '\'' +
                '}';
    }
}