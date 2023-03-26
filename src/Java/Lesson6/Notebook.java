package Java.Lesson6;

import java.util.Objects;

public class Notebook {
    public String brand;
    public String model;
    public int ram;
    public int memory;

    public Notebook(String brand, String model, int ram, int memory){
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.memory = memory;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public int getRam(){
        return ram;
    }
    public void setRam(int ram){
        this.ram = ram;
    }
    public int getMemory(){
        return memory;
    }
    public void setMemory(int memory){
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Ноутбук бренда " + brand + ", модель " + model + ", оперативная память в гигабайтах: " + ram + ", " +
                "жесткий диск на " + memory + " ГБ.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return ram == notebook.ram && memory == notebook.memory && brand.equals(notebook.brand) && model.equals(notebook.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, ram, memory);
    }
}
