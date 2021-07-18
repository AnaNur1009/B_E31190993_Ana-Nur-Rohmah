package com.kelompok1.labs.ptaniapp.helper;

import com.kelompok1.labs.ptaniapp.model.Category;
import com.kelompok1.labs.ptaniapp.model.Product;

import java.util.ArrayList;
import java.util.List;
public class Data {
    List<Category> categoryList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    List<Product> newList = new ArrayList<>();
    List<Product> popularList = new ArrayList<>();

    public List<Category> getCategoryList() {
        Category category = new Category("1", "View Produk", "https://image.flaticon.com/icons/png/512/262/262344.png");
        categoryList.add(category);
        return categoryList;
    }
    public List<Product> getProductList() {
        Product product = new Product("4", "1", "Sorgum / kg", "Non Organik", "", "Rp.", "4.000", "", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/th%20(2).jfif?alt=media&token=6339a384-35da-4f99-bdf9-c287975f0a1a");
        productList.add(product);
        product = new Product("4", "1", "Jagung / kg", "Non Organik.", "", "Rp.", "6.000", "", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/jagung.jpg?alt=media&token=18b1127c-d1bd-4165-8641-b61b65e76efd");
        productList.add(product);
        product = new Product("2", "2", "Cabai / kg", "Organik", "", "Rp.", "28.000", "", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/cabai.jpeg?alt=media&token=1e05fa75-9722-4e8b-807a-3a1440e400d8");
        productList.add(product);
        product = new Product("3", "2", "Jambu /kg", "Organik ", "", "Rp.", "21.000", "", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/jambu.jpg?alt=media&token=e5860e49-cb1c-4e71-bffe-cc8461c2141b");
        productList.add(product);
        product = new Product("2", "3", "Kacang Panjang / ikat", "Organik", "", "Rp.", "5.000", "", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/kacang%20panjang.jpeg?alt=media&token=93cfa46f-b251-42da-843c-764d8658be65");
        productList.add(product);

        return productList;
    }

    public List<Product> getNewList() {
        Product product = new Product("4", "1", "Sorgum / kg", " Non Organik ", "", "Rp.", "4.000", "", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/th%20(2).jfif?alt=media&token=6339a384-35da-4f99-bdf9-c287975f0a1a");
        newList.add(product);
        product = new Product("4", "1", "Jagung / kg", "Non Organik.", "", "Rp.", "6.000", "", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/jagung.jpg?alt=media&token=18b1127c-d1bd-4165-8641-b61b65e76efd");
        newList.add(product);
        product = new Product("2", "2", "Cabe Merah Besar / kg", "Organik", "", "Rp.", "28.000", "", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/cabai.jpeg?alt=media&token=1e05fa75-9722-4e8b-807a-3a1440e400d8");
        newList.add(product);
        product = new Product("3", "2", "Jambu /kg", "Organik ", "", "Rp.", "21.000", "", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/jambu.jpg?alt=media&token=e5860e49-cb1c-4e71-bffe-cc8461c2141b");
        newList.add(product);
        product = new Product("2", "3", "Kacang Panjang / ikat", "Organik", "", "Rp.", "5.000", "", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/kacang%20panjang.jpeg?alt=media&token=93cfa46f-b251-42da-843c-764d8658be65");
        newList.add(product);
        return newList;
    }

    public List<Product> getPopularList() {
        Product product = new Product("1", "3", "Ubi Madu Cilembu / kg", "Non Organik", "", "Rp.", "10.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/ubi%20madu.jpeg?alt=media&token=e231dbde-a798-420f-9227-9b18a8da926d");
        popularList.add(product);
        product = new Product("3", "4", "Alpukat Mentega / kg", "Organik", "", "Rp.", "17.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Alpukat%20Mentega.jpg?alt=media&token=e1cf4308-538e-45ec-bb39-9d11dc2cb852");
        popularList.add(product);
        product = new Product("2", "5", "Selada Air / ikat", "Organik", "", "Rp.", "3.500", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Slada%20Air.jpeg?alt=media&token=7211a14c-8305-4cc8-9025-e4e4944321a6");
        popularList.add(product);
        product = new Product("3", "5", "Anggur / kg", "Non Organik", "", "Rp.", "26.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Anggur.jpeg?alt=media&token=4c691340-f6ae-4ecd-b2e4-b528ce6e76ea");
        popularList.add(product);
        product = new Product("4", "1", "Kopi Arabika/ kg ", " Non Organik.", "", "Rp.", "20.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Kopi.jpeg?alt=media&token=bae9e6a1-7a1c-4192-900a-3ce8062d35ea");
        popularList.add(product);
        product = new Product("4", "1", "Edamame / kg", "Non Organik", "", "Rp.", "25.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Edamame.jpeg?alt=media&token=31788b0e-4b9f-47a3-ba6b-fab55a2412fc");
        popularList.add(product);
        product = new Product("3", "1", "Jambu Merah Biji/ kg", "Non Organik ", "", "Rp.", "8.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Jambu%20Merah%20Biji.jpg?alt=media&token=12283bbc-6a5f-45e4-a906-9314db9bf080");
        popularList.add(product);
        product = new Product("2", "1", "Wortel / kg", "Non Organik ", "", "Rp.", "13.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/wortel%202.jpeg?alt=media&token=de5678a7-4c34-44d9-9306-ffc64f7a507f");
        popularList.add(product);
        product = new Product("2", "1", "Tomat / kg", "Non Organik", "", "Rp.", "10.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/tomat.jpeg?alt=media&token=ed6e6454-afb4-43a5-8ef0-f3985fc0bc23");
        popularList.add(product);
        product = new Product("3", "1", "Jeruk Semboro / kg", "Non Organik", "", "Rp.", "10.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Jeruk%20Semboro.jpg?alt=media&token=d6d9d0a4-e7f2-4b11-bea9-dd9f3cf42f98");
        popularList.add(product);
        product = new Product("1", "1", "Padi / kg", " ", "Non Organik", "Rp.", "8.500", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/padi.jpg?alt=media&token=dd39f3fc-576b-441b-bd2a-c6a3005b0f0a");
        popularList.add(product);
        product = new Product("3", "1", "Pisang Ambon / sisir", "Organik ", "", "Rp.", "18.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Pisang.jpeg?alt=media&token=7fb7a091-9b00-4828-968a-7031148bd180");
        popularList.add(product);
        product = new Product("3", "1", "Duren / buah", "Non Organik ", "", "Rp.", "25.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Duren.jpg?alt=media&token=8f3d7547-3f8d-4b10-b1e0-c42185819cbe");
        popularList.add(product);
        product = new Product("3", "1", "Rambutan Binjai / kg", "Non Organik", "", "Rp.", "10.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Rmabutan.jpg?alt=media&token=9694205a-33ba-4e4e-accf-19d143557dab");
        popularList.add(product);
        product = new Product("1", "1", "Ketela Pohon / kg", "Non Organik", "", "Rp.", "5.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Ketela-Pohon.jpg?alt=media&token=9a3260b8-57ab-4d67-8f60-cc77bc0ccf09");
        popularList.add(product);
        product = new Product("1", "1", "Ubi Ungu / kg", "Non Organik ", "", "Rp.", "5.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Ubi%20Ungu.jpg?alt=media&token=29650492-4e9e-4fb5-bce4-6ed84f232039");
        popularList.add(product);
        product = new Product("1", "1", "Labu Kuning / buah", "Non Organik", "", "Rp.", "7.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Labu%20Kuning.jpg?alt=media&token=6df950ba-c724-4025-af8b-b7afc9f31c4f");
        popularList.add(product);
        product = new Product("2", "1", "Labu Siam / kg", "Non Organik", "", "Rp.", "5.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Labu%20Siam.jpg?alt=media&token=acda0571-8d69-4236-9463-f72cf0401c55");
        popularList.add(product);
        product = new Product("3", "1", "Melon / kg", "Non Organik", "", "Rp.", "5.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Melon.jpg?alt=media&token=afe504b0-4565-4c0e-83bc-afcd3a098770");
        popularList.add(product);
        product = new Product("3", "1", "Semangka / kg", "Non Organik ", "", "Rp.", "5.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Semangka.jpg?alt=media&token=45ad8ddc-af27-466f-b1f0-3fdd42237805");
        popularList.add(product);
        product = new Product("3", "3", "Semangka Non Biji / kg", "Organik", "", "Rp.", "7.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Semangka%20Non%20Biji.jpg?alt=media&token=99c9addb-eb04-4f10-a19c-d04b36d42d6a");
        popularList.add(product);
        product = new Product("2", "3", "Cabe Rawit / kg", "Non Organik", "", "Rp.", "30.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Cabe%20Rawit.jpg?alt=media&token=f38a4bda-de25-47db-a2cd-6c9be164bc81");
        popularList.add(product);
        product = new Product("2", "3", "Timun / kg", "Non Organik", "", "Rp.", "10.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Timun.jpg?alt=media&token=e03fd3a9-8dde-4c3b-b61d-b03c752d9dab");
        popularList.add(product);
        product = new Product("2", "3", "Kubis / kg", "Non Organik", "", "Rp.", "5.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Kubis.jpg?alt=media&token=17aac5d6-373a-44fa-9a83-4824d05b512e");
        popularList.add(product);
        product = new Product("2", "3", "Pakcoy / kg", "Non Organik", "", "Rp.", "4.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Pakcoy.png?alt=media&token=c820f9b9-ac6c-420b-8196-f5b560c9fdab");
        popularList.add(product);
        product = new Product("2", "3", "Kembang Kol / kg", "Non Organik", "", "Rp.", "6.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Kembang%20Kol.jpg?alt=media&token=dee0f2e2-7990-4380-99d5-f7b63a8e8c0f");
        popularList.add(product);
        product = new Product("2", "3", "Pare / kg", "Non Organik", "", "Rp.", "3.500", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Pare.jpg?alt=media&token=0507b45a-5fb3-4cb2-b37d-249b7c636808");
        popularList.add(product);
        product = new Product("2", "3", "Brokoli / kg", "Non Organik", "", "Rp.", "8.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Brokoli.jpg?alt=media&token=f60c1303-f40b-460e-8364-32707bde0156");
        popularList.add(product);
        product = new Product("2", "3", "Buncis / kg", "Non Organik", "", "Rp.", "7.000", "-", "https://firebasestorage.googleapis.com/v0/b/p-tani.appspot.com/o/Buncis.webp?alt=media&token=4b70a817-99e6-4580-bfe8-ad2378684647");
        popularList.add(product);
        return popularList;

    }
}
