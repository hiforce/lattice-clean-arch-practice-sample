package org.hiforce.sample.buynow.web.config;

import org.hiforce.lattice.runtime.Lattice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Rocky Yu
 * @since 2022/10/8
 */
@Component
public class LatticeInitConfig implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Lattice.getInstance().setSimpleMode(true);//no business config file, simple mode.
        Lattice.getInstance().start();
        System.out.println(">>> Lattice started!");
    }
}