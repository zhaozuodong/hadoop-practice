package pub.zzd.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * @Description : Hbase连接尝试
 * @Author : ZZD
 * @CreateTime : 2019/4/12 14:31
 */
public class HBaseConnection {
    public static void main(String[] args) throws IOException {
        // 第一步，设置HBsae配置信息
        Configuration configuration = HBaseConfiguration.create();
        // 注意。这里这行目前没有注释掉的，这行和问题3有关系  是要根据自己zookeeper.znode.parent的配置信息进行修改。
        // 与 hbase-site-xml里面的配置信息 zookeeper.znode.parent 一致
//        configuration.set("zookeeper.znode.parent","/hbase-unsecure");
        // hbase 服务地址
        configuration.set("hbase.zookeeper.quorum","192.168.1.100");
        // 端口号
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        // 这里使用的是接口Admin   该接口有一个实现类HBaseAdmin   也可以直接使用这个实现类
        // HBaseAdmin baseAdmin = new HBaseAdmin(configuration);
        Admin admin = ConnectionFactory.createConnection(configuration).getAdmin();
        if(admin != null){
            try {
                //获取到数据库所有表信息
                HTableDescriptor[] allTable = admin.listTables();
                for (HTableDescriptor hTableDescriptor : allTable) {
                    System.out.println(hTableDescriptor.getNameAsString());
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
