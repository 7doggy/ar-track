package com.ar.track.artrack;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import com.nlink.FrameEventListener;
import com.nlink.NLink;
import com.nlink.NLinkReader;
import com.nlink.extractor.AnchorFrame0Extractor;
import com.nlink.frame.AnchorFrame0;
import com.nlink.frame.Frame;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TrackHandler implements ApplicationRunner {

    @Value("${nlink.com}")
    private String com;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 实例化串口操作类对象,串口号，波特率，数据位，停止位，校验位
        NLink nlk = new NLink(com, 921600, 8, 1, 0);
        // 创建NLinkReader实例
        NLinkReader manager = new NLinkReader(nlk);
        // 添加需要解析的帧的解析器，本示例仅解析AnchorFrame0帧。
        // 如果需要解析其它类型帧，根据需要添加对应帧的解析器。
        manager.addExtractor(new AnchorFrame0Extractor());
        // 添加帧事件监听器，通过回调获取帧数据。
        // 本示例仅仅作为示例使用，未进行类型判断、逻辑判断、业务处理等。
        // 具体根据使用场景自行处理。
        manager.setFrameEventListener(new FrameEventListener() {
            @Override
            public void onArrival(Frame frame) {
                AnchorFrame0 anch = (AnchorFrame0) frame;
                System.out.println(LocalDateTime.now() + " " + Arrays.toString(anch.getTags().get(0).getPostion()));
            }

            @Override
            public void onArrival(Collection<Frame> frames) {
                frames.forEach(e -> onArrival(e));
            }
        });

        // 开始,打开串口，开始监听读取串口数据
        manager.start();
        /** 
        int i = 10000;
        while (i-- > 0) {
            TimeUnit.SECONDS.sleep(3);
        }
        // 结束，关闭串口，停止监听串口数据
        manager.stop();
        */

    }

}
