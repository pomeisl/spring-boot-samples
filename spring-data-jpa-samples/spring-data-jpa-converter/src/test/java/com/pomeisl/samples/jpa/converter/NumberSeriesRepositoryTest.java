package com.pomeisl.samples.jpa.converter;

import com.google.common.collect.ImmutableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class NumberSeriesRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void givenSeries_whenSaving_thenConcat() {
        // given
        NumberSeries ns = NumberSeries.builder().series(ImmutableList.of(1L, 2L)).build();

        em.persist(ns);
        em.flush();

        // when
        String series = (String) em
                .createNativeQuery("SELECT n.series FROM number_series as n WHERE n.id = :id")
                .setParameter("id", ns.getId())
                .getSingleResult();

        // then
        assertThat(series).isEqualTo("1,2");
    }
}
