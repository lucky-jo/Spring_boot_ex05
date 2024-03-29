package com.sduty.spring_boot_ex05.repository;

import com.sduty.spring_boot_ex05.domain.Block;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class BlockRepositoryTest {

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void crud() {
        Block block = new Block();
        block.setName("martin");
        block.setReason("친하지 않아서");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now());

        blockRepository.save(block);

        List<Block> blockList = blockRepository.findAll();

        Assertions.assertThat(blockList.size()).isEqualTo(1);
        Assertions.assertThat(blockList.get(0).getName()).isEqualTo("martin");
    }
}
