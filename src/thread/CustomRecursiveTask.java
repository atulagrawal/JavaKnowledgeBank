package thread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private String path;
    private String extension;
    
    public CustomRecursiveTask(String path,String extension) {
        this.path = path;
        this.extension = extension;
    }
    @Override
    protected Integer compute() {
        List<String> fileList = new ArrayList<>();
        List<CustomRecursiveTask> tasks = new ArrayList<>();
        File file = new File(path);
        if(file.exists()) {
            File[] contents = file.listFiles();
            if(contents!=null) {
                for (File content : contents) {
                   
                    if(content.isDirectory()) {
                        CustomRecursiveTask task = new CustomRecursiveTask(content.getAbsolutePath(), extension);
                        task.fork();
                        tasks.add(task);
                    } else {
                        if(content.getName().endsWith(extension)) {
                         //   System.out.println(content.getName());
                            fileList.add(content.getName());
                        }
                    }
                }
            }
        }
        int count=fileList.size();
        for (CustomRecursiveTask customRecursiveTask : tasks) {
                count =count + customRecursiveTask.join();
         }
        return count;
    }


}
